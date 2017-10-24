(Unix I-node block mapping)
• I-node contains 13 block pointers
– first 10 point to first 10 blocks of file
– 11th points to an indirect block (e.g. 4k bytes = 1k blocks)
– 12th points to a double indirect block (w/1k indirect blocks) – 13th points to a triple indirect block (w/1k double indirs)
• assuming 4k bytes per block and 4-bytes per pointer – 10 direct blocks = 10 * 4K bytes = 40K bytes
– indirect block = 1K * 4K = 4M bytes
– double indirect = 1K * 4M = 4G bytes
– triple indirect = 1K * 4G = 4T bytes (finite, but large)
///////////////////
I-nodes – performance
• I-nodeisinmemorywheneverfileisopen • first ten blocks can be found with no I/O
• after that, we must read indirect blocks
– the real pointers are in the indirect blocks
– sequential file processing will keep referencing it – block I/O will keep it in the buffer cache
• 1-3 extra I/O operations per thousand pages – any block can be found with 3 or fewer reads
• index blocks can support "sparse" files
• block#widthdeterminesmaxfilesystemsize
/////////////////////
2. Definitions
2.1. Blocks
2.2. Block Groups
2.3. Directories
2.4. Inodes
2.5. Superblocks
2.6. Symbolic Links
3. Disk Organization
3.1. Superblock
3.1.1. s_inodes_count
3.1.2. s_blocks_count
3.1.3. s_r_blocks_count
3.1.4. s_free_blocks_count
3.1.5. s_free_inodes_count
3.1.6. s_first_data_block
3.1.7. s_log_block_size
3.1.8. s_log_frag_size
3.1.9. s_blocks_per_group
3.1.10. s_frags_per_group
3.1.11. s_inodes_per_group
3.1.12. s_mtime
3.1.13. s_wtime
3.1.14. s_mnt_count
3.1.15. s_max_mnt_count
3.1.16. s_magic
3.1.17. s_state
3.1.18. s_errors
3.1.19. s_minor_rev_level
3.1.20. s_lastcheck
3.1.21. s_checkinterval
3.1.22. s_creator_os
3.1.23. s_rev_level
3.1.24. s_def_resuid
3.1.25. s_def_resgid
3.1.26. s_first_ino
3.1.27. s_inode_size
3.1.28. s_block_group_nr
3.1.29. s_feature_compat
3.1.30. s_feature_incompat
3.1.31. s_feature_ro_compat
3.1.32. s_uuid
3.1.33. s_volume_name
3.1.34. s_last_mounted
3.1.35. s_algo_bitmap
3.1.36. s_prealloc_blocks
3.1.37. s_prealloc_dir_blocks
3.1.38. s_journal_uuid
3.1.39. s_journal_inum
3.1.40. s_journal_dev
3.1.41. s_last_orphan
3.1.42. s_hash_seed
3.1.43. s_def_hash_version
3.1.44. s_default_mount_options
3.1.45. s_first_meta_bg
3.2. Block Group Descriptor Table
3.2.1. bg_block_bitmap
3.2.2. bg_inode_bitmap
3.2.3. bg_inode_table
3.2.4. bg_free_blocks_count
3.2.5. bg_free_inodes_count
3.2.6. bg_used_dirs_count
3.2.7. bg_pad
3.2.8. bg_reserved
3.3. Block Bitmap
3.4. Inode Bitmap
3.5. Inode Table
3.5.1. i_mode
3.5.2. i_uid
3.5.3. i_size
3.5.4. i_atime
3.5.5. i_ctime
3.5.6. i_mtime
3.5.7. i_dtime
3.5.8. i_gid
3.5.9. i_links_count
3.5.10. i_blocks
3.5.11. i_flags
3.5.12. i_osd1
3.5.13. i_block
3.5.14. i_generation
3.5.15. i_file_acl
3.5.16. i_dir_acl
3.5.17. i_faddr
3.5.18. Inode i_osd2 Structure
3.6. Locating an Inode
http://www.nongnu.org/ext2-doc/ext2.html#DEF-INODES